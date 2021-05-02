package com.xpr.dao.core.controller;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.annotation.XprRole;
import com.xpr.dao.core.view.JsonPage;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.dao.helper.GenericSearchSpecification;
import com.xpr.dao.helper.XprBaseModel;
import com.xpr.entities.Colis;
import com.xpr.entities.Utilisateur;
import com.xpr.excel.ExcelUtils;
import com.xpr.services.ExportService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public abstract class SecuredCRUDController<T, V extends Serializable> {

    public com.xpr.dao.UtilisateurRepository userRepository;
    
    public CustomJPARepository<T, V> repository;

    public static final int DEFAULT_PAGE_SIZE = 25;
    public static final String DEFAULT_SORT_COLUMN = "createdDate";
    public static final String DEFAULT_SORT_ORDER = "DESC";
    @Autowired
    public ExportService exportService;
   
    @Autowired
    public void setUtilisateurRepository(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkEligibilityClient(T object) {
        Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
        Set<String> usersClient = (Set<String>) request.get().getAttribute("usersClient");

        if (object instanceof XprBaseModel) {
            String objectCreator = ((XprBaseModel) object).getCreatedBy();
            return objectCreator != null && usersClient.contains(objectCreator);
        }

        return false;
    }

    public boolean checkEligibilityEntite(T object) {
    	 Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
         Set<String> usersEntite = (Set<String>) request.get().getAttribute("usersEntite");

         if (object instanceof XprBaseModel) {
             String objectCreator = ((XprBaseModel) object).getCreatedBy();
             return objectCreator != null && usersEntite.contains(objectCreator);
         }

         return false;
    }

    public boolean checkEligibilityMapped(T object) {
        return false;
    }

    public boolean checkEligibility(T object) {
        if (object == null) return false;

        Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
        boolean authorized = false;
        if (request.isPresent()) {
            List<String> actionUserRoles = (List<String>) request.get().getAttribute("actionUserRoles");

            
            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$CLIENT"))) {
                request.get().setAttribute("role", "CLIENT");
                authorized = this.checkEligibilityClient(object);
                
            }

            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$ENTITE"))) {
                request.get().setAttribute("role", "ENTITE");
                authorized = this.checkEligibilityEntite(object);
               
            }

            if (actionUserRoles.stream().anyMatch(authority -> authority.contains("$ALL"))) {
                request.get().setAttribute("role", "ALL");
                authorized = true;
               
            }
        }
        return authorized;
    }
    
    public boolean checkEligibility() {
        
        Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
        boolean authorized = false;
        if (request.isPresent()) {
            List<String> actionUserRoles = (List<String>) request.get().getAttribute("actionUserRoles");

            if (actionUserRoles.stream().anyMatch(authority -> authority.contains("$ALL"))) {
                request.get().setAttribute("role", "ALL");
                authorized = true;
               
            }
            
            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$ENTITE"))) {
                request.get().setAttribute("role", "ENTITE");
                authorized = true;
               
            }
            
            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$CLIENT"))) {
                request.get().setAttribute("role", "CLIENT");
                authorized = true;
                
            }
            
            
            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$LIVREUR"))) {
                request.get().setAttribute("role", "LIVREUR");
                authorized = true;
               
            }
            
            if (!authorized && actionUserRoles.stream().anyMatch(authority -> authority.contains("$RAMASSEUR"))) {
                request.get().setAttribute("role", "RAMASSEUR");
                authorized = true;
               
            }

            
        }
        return authorized;
    }

 

 
    public Optional<HttpServletRequest> getCurrentHttpRequest() {
        return
                Optional.ofNullable(
                        RequestContextHolder.getRequestAttributes()
                )
                        .filter(ServletRequestAttributes.class::isInstance)
                        .map(ServletRequestAttributes.class::cast)
                        .map(ServletRequestAttributes::getRequest);
    }

    public Set<T> getFilteredObjects(Collection<T> objects) {
        return objects.stream().filter(
                object -> {
                    try {
                        return this.checkEligibility(object);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
        ).collect(Collectors.toSet());
    }

    /**
     * An API to create a new entity, if the creation is ok
     * the newly created entity will be returned, else a 400 error
     * will be returned.
     *
     * @param T object
     * @return T
     */
    @CrossOrigin
    @PostMapping(path = "/create")
    @XprRole(role = XprRole.Role.CREATE, view = "ModelViews.FullView")
    public T create(@Valid @RequestBody T object) {
        if (!this.isAdmin())
            this.checkCreateCustomRoles(object);
        this.preCreate(object);
        object = (T) this.repository.save(object);
        this.repository.refresh(object);
        this.postCreate(object);
        return object;
    }

    /**
     * An API to retrieve a given object by its ID
     *
     * @param V id
     * @return T
     */
    @CrossOrigin
    @GetMapping(path = "/get/{id}")
    @XprRole(role = XprRole.Role.LIST, view = "ModelViews.FullView")
    public T get(@PathVariable("id") V id) {
        return _get(id);
    }

    @CrossOrigin
    @GetMapping(path="/get")
    @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
    public T getWithQueryParam(@QueryParam("id") V id) {
        return _get(id);
    }

    public T _get(V id) {
        Optional<T> result = this.repository.findById(id);
        if (result.isPresent()) {
            if (this.checkEligibility(result.get()))
                return result.get();
            else
                throw new AccessDeniedException("Unauthorized operation");
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * An API to update a given object by it's ID, if the update is ok it
     * will return the updated object else a 400 error will be returned
     *
     * @param V id
     * @param T object
     * @return T
     */
    @CrossOrigin
    @PostMapping(path = "/update/{id}")
    @XprRole(role = XprRole.Role.UPDATE, view = "ModelViews.FullView")
    public T update(@PathVariable("id") V id, @Valid @RequestBody T object) {
        return _update(id, object);
    }
    @CrossOrigin
    @PostMapping(path = "/update")
    @XprRole(role = XprRole.Role.UPDATE, view = "ModelViews.FullView")
    public T updateWithQueryParam(@QueryParam("id") V id, @Valid @RequestBody T object) {
        return _update(id, object);
    }
    public T _update(V id, T object) {
        this.setIdentifier(id, object);
        Optional<T> source = this.repository.findById(id);
        if (source.isPresent()) {
            if (this.checkEligibility(source.get())) {
                if (!this.isAdmin())
                    this.checkUpdateCustomRoles(source.get());
                this.preUpdate(object);
                object = (T) this.repository.save(object);
                this.repository.refresh(object);
                this.postUpdate(object);
                return object;
            } else {
                throw new AccessDeniedException("Unauthorized operation");
            }
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * An API to delete a given object by its ID
     *
     * @param V id
     * @return T
     */
    @CrossOrigin
    @PostMapping(path = "/delete/{id}")
    @XprRole(role = XprRole.Role.DELETE, view = "ModelViews.FullView")
    public synchronized ResponseEntity delete(@PathVariable("id") V id) throws IOException {
        Optional<T> object = this.repository.findById(id);

        if (object.isPresent()) {
            if (this.checkEligibility(object.get())) {
                if (!this.isAdmin())
                    this.checkDeleteCustomRoles(object.get());
                try{
                    this.repository.deleteById(id);
                }
                catch (DataIntegrityViolationException e){
                    return new ResponseEntity<>("DataIntegrityViolationException", HttpStatus.INTERNAL_SERVER_ERROR);
                }
                catch(Exception e){
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
                this.postDelete(object.get());
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new AccessDeniedException("Unauthorized operation");
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @PostMapping(path = "/delete")
    @XprRole(role = XprRole.Role.DELETE, view = "ModelViews.FullView")
    public synchronized List<V> delete(@RequestBody V[] ids) throws IOException {
        List<V> deletedIds = new ArrayList<>();
        for(V id : ids) {
            try{
                Optional<T> object = this.repository.findById(id);
                if (object.isPresent()) {
                    if (this.checkEligibility(object.get())) {
                        if (!this.isAdmin())
                            this.checkDeleteCustomRoles(object.get());
                        this.repository.deleteById(id);
                        this.postDelete(object.get());
                        deletedIds.add(id);
                    }
                }
            }
            catch (Exception e){ e.printStackTrace(); }
        }
        return deletedIds;
    }
   
    
    
    public Map<String, ?> parseSearchParams(Map<String, String> searchParams) {
        return searchParams;
    }

    /**
     * An abstract method that will need to be implemented by subclasses
     * will set the ID of a given object to that object
     *
     * @param V id
     * @param T object
     */
    public abstract void setIdentifier(V id, T object);

    /**
     * An API to list objects of a given type to be shown in a select toggle
     *
     * @return Set<T>
     */
    @CrossOrigin
    @GetMapping(path = "/list/select")
    @XprRole(role = XprRole.Role.LIST, view = "ModelViews.SelectView")
    public Set<T> listSelect() {
        List<T> result = (List<T>) this.repository.findAll();
        if (this.isAdmin()) {
           
            return new HashSet<>(result);
        }
        return this.getFilteredObjects(result);
    }
    
    /**
     * An API to list objects of a given type
     *
     * @return List<T>
     */
    @JsonView(ModelViews.ListView.class)
    @XprRole(role = XprRole.Role.LIST,view = "ModelViews.FullView")
    public ResponseEntity<Page<T>> list(@RequestParam(defaultValue="{}", required = false) Map<String,String> params, GenericSearchSpecification searchSpecifications) {
    	
        int page = params.get("page") != null ? Integer.parseInt(params.remove("page")): 0;
        int pageSize = params.get("size") != null ? Integer.parseInt(params.remove("size")) : DEFAULT_PAGE_SIZE;
        String sortColumn = params.get("sortColumn") != null ? params.remove("sortColumn") : DEFAULT_SORT_COLUMN;
        String sortOrder = params.get("sortOrder") != null ? params.remove("sortOrder") : DEFAULT_SORT_ORDER;
        Sort sort = sortOrder.equals("DESC") ? Sort.by(sortColumn).descending() : Sort.by(sortColumn).ascending();

        Pageable dataPage = PageRequest.of(page, pageSize, sort);
        Page<T> result;
        
        
      
	        Map<String, Object> parsedParams = null;
	
	        if (params.size() > 0) {
	            parsedParams = Collections.unmodifiableMap(this.parseSearchParams(params));
	        }
	       
	        if(searchSpecifications==null) {
	        	searchSpecifications = new GenericSearchSpecification(parsedParams,null);
	        }
	        
	        result =  this.repository.findAll(searchSpecifications, dataPage);
	        JsonPage<T> jsonPage = new JsonPage<>(result, dataPage);
	        return new ResponseEntity<>(jsonPage, HttpStatus.OK);

        
    }
    
    @JsonView(ModelViews.ListView.class)
    @XprRole(role = XprRole.Role.LIST,view = "ModelViews.FullView")
    public ResponseEntity<Page<T>> listSpecification(GenericSearchSpecification<T> searchSpecifications , @RequestParam(defaultValue="{}", required = false) Map<String,String> params) {
    	
        int page = params.get("page") != null ? Integer.parseInt(params.remove("page")): 0;
        int pageSize = params.get("size") != null ? Integer.parseInt(params.remove("size")) : DEFAULT_PAGE_SIZE;
        String sortColumn = params.get("sortColumn") != null ? params.remove("sortColumn") : DEFAULT_SORT_COLUMN;
        String sortOrder = params.get("sortOrder") != null ? params.remove("sortOrder") : DEFAULT_SORT_ORDER;
        Sort sort = sortOrder.equals("DESC") ? Sort.by(sortColumn).descending() : Sort.by(sortColumn).ascending();

        Pageable dataPage = PageRequest.of(page, pageSize, sort);
        Page<T> result;
        
        	     
        result =  this.repository.findAll(searchSpecifications, dataPage);
        JsonPage<T> jsonPage = new JsonPage<>(result, dataPage);
        return new ResponseEntity<>(jsonPage, HttpStatus.OK);

        
    }
    
    
	
	
    
    @CrossOrigin
    @PostMapping(path = "/export-list")
    @XprRole(role = XprRole.Role.LIST, view = "ModelViews.FullView")
	public ResponseEntity<Resource> exportListExcel(@RequestParam(name = "headers") String[] headers,@RequestBody Set<Object[]> data_list) {
		XSSFWorkbook workbook = null;
		Resource file = null;
		String fileName = null;
		try {
			/* Logic to Export Excel */
			LocalDateTime localDate = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
			fileName = "Etat" + "-" + localDate.format(formatter) + ".xlsx";
			OutputStream out;
			workbook = (XSSFWorkbook) ExcelUtils.generateWorkBookList(headers,data_list);
		    File directory = new File("upload-dir");
		    if (! directory.exists() || !directory.isDirectory()){
		        directory.mkdir();
		    }
			FileOutputStream fileOut = new FileOutputStream("upload-dir/" + fileName);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			file = exportService.loadFile(fileName);
		} catch (Exception ecx) {
			ecx.printStackTrace();
	
		} 
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(file);
	}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    public boolean isSuperSuperAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        Utilisateur user = this.userRepository.findByEmail(login);
        return user.getProfiles().stream().anyMatch(profil -> "Super Super Admin".equals(profil.getPrflName()));
    }
    
    public boolean isSuperAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        Utilisateur user = this.userRepository.findByEmail(login);
        return user.getProfiles().stream().anyMatch(profil -> "Super Admin".equals(profil.getPrflName()));
    }
    
    public boolean isAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        Utilisateur user = this.userRepository.findByEmail(login);
        return user.getProfiles().stream().anyMatch(profil -> "Admin".equals(profil.getPrflName()));
    }

    public void preCreate(T object) {
    }

    public void postCreate(T object) {
    }

    public void preUpdate(T object) {
    }

    public void postUpdate(T object) {
    }

    public void postDelete(T object) {
    }

    public void checkCreateCustomRoles(T object) {
    }

    public void checkDeleteCustomRoles(T object) {
    }

    public void checkUpdateCustomRoles(T object) {
    }

    public Utilisateur getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        return this.userRepository.findByEmail(login);
    }
    
}