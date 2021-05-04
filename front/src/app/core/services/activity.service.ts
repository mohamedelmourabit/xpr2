import {Injectable} from "@angular/core";
import {AuthenticationService} from "./authentification.service";
import {Activity} from "../model/model.activity";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import * as moment from "moment-timezone";
import {host} from "./host";
import {User} from "../model/model.user";

@Injectable()
export class ActivityService{

  private host = host;

  constructor(private authenticationService:AuthenticationService,private  http:HttpClient){}

  saveListActivity(listActivity:Array<Activity>) {
    listActivity.forEach(activity=>{
      activity.createdBy.username = this.authenticationService.getUserName();
    });
    return this.http.post(this.host+'/save-list-activity',listActivity,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  saveListActivityDirection(listActivity:Array<Activity>) {
    return this.http.post(this.host+'/save-list-activity-direction',listActivity,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  saveActivityWithoutTest(activity:Activity) {

    activity.createdBy = new User();
    activity.createdBy.username = this.authenticationService.getUserName();
    return this.http.post(this.host+'/save-activity-without-test',activity,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  findMyActivityProject(mc:string,page:number,size:number,start:string) {
    return this.http.get(this.host+"/findMyActivityProject?username="+this.authenticationService.getUserName()+"&start="+start+"&motCle="+mc+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllMyActivitiesByDates(dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllMyActivitiesByDates?username='+this.authenticationService.getUserName()+"&dteStrt="+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllMyActivitiesByDatesForDay(dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllMyActivitiesByDatesForDay?username='+this.authenticationService.getUserName()+"&dteStrt="+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllActivitiesByDates(dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllActivitiesByDates?dteStrt='+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllActivitiesByDatesForDay(dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllActivitiesByDatesForDay?dteStrt='+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllActivitiesByDatesAndService(username:string, dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllActivitiesByDatesAndService?idService='+this.authenticationService.getIdService()+'&username='+username+'&dteStrt='+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllActivitiesByDatesForDayAndService(username:string, dteStrt:string,dteEnd:string){
    return this.http.get(this.host+'/findAllActivitiesByDatesForDayAndService?idService='+this.authenticationService.getIdService()+'&username='+username+'&dteStrt='+dteStrt+"&dteEnd="+dteEnd,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }


  getActivityTomorrow() {
    return this.http.get(this.host+"/activitytomorrow?username="+this.authenticationService.getUserName(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getActivityToday() {
    return this.http.get(this.host+"/activitytoday?username="+this.authenticationService.getUserName(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getLastActivity() {
    return this.http.get(this.host+"/lastactivity?username="+this.authenticationService.getUserName(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getMyActivitiesByMc(mc:string,page:number,size:number, typeSelected:any){
    return this.http.get(this.host+"/findMyActivitiesByMc?username="+this.authenticationService.getUserName()+"&motCle="+mc+"&size="+size+"&page="+page+"&type="+typeSelected.toString(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllActivitiesByMc(mc:string,page:number,size:number, typeSelected:any){
    return this.http.get(this.host+"/findAllActivitiesByMc?motCle="+mc+"&size="+size+"&page="+page+"&type="+typeSelected.toString(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  saveActivity(activity:Activity){
    activity.createdBy.username = this.authenticationService.getUserName();
    return this.http.post(this.host+'/activities',activity,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getActivity(id:number){
    return this.http.get(this.host+'/activities/'+id,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  updateActivity(activity:Activity){
    return this.http.put(this.host+'/activities/'+activity.id,activity,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  deleteActivity(id:number){
    return this.http.delete(this.host+'/activities/'+id,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getActivityToDo(mc:string,page:number,size:number) {
    return this.http.get(this.host+"/activityToDo?username="+this.authenticationService.getUserName()+"&motCle="+mc+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getMyActivityHoliday(page:number, size:number) {
    return this.http.get(this.host+"/myactivityholiday?username="+this.authenticationService.getUserName()+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})})
  }

  getActivityHolidayForUser(username:string, page:number, size:number) {
    return this.http.get(this.host+"/myactivityholiday?username="+username+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})})
  }

  getActivityRequestByTicket(rqtExcde:string, page:number, size:number) {
    return this.http.get(this.host+"/getActivityRequestByTicket?rqtExcde="+rqtExcde+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})})

  }

  getActivityByService(username:string,mc:string,page:number,size:number, typeSelected:any) {
    return this.http.get(this.host+"/getActivityByService?idService="+this.authenticationService.getIdService()+"&username="+username+"&motCle="+mc+"&size="+size+"&page="+page+"&type="+typeSelected.toString(),{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getActivityPlanifiedDirection(username:string,mc:string,page:number,size:number) {
    return this.http.get(this.host+"/getActivityPlanifiedDirection?username="+username+"&motCle="+mc+"&size="+size+"&page="+page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  formatDate(date:any){
    return moment(date).tz("Africa/Casablanca").format('DD/MM/YYYY HH:mm:ss');
  }

  diffBetwenTwoDateInMinutes(dteStrt:Date,dteEnd:Date){
    var dateDeb = this.formatDate(dteStrt);
     var dateFin = this.formatDate(dteEnd);
     var ms = moment(dateFin,"DD/MM/YYYY HH:mm").diff(moment(dateDeb,"DD/MM/YYYY HH:mm"));
     var d = moment.duration(ms);
   /* console.log("duration as Hours " + d.asHours());
    console.log("duration as Minutes " + d.asMinutes());
    console.log("duration as seconde " + d.asSeconds());*/
     var s = Math.floor(d.asHours()) + moment.utc(ms).format(":mm:ss");
    return d.asMinutes();

  }

  diffBetwenTwoDateFormated(dteStrt:Date,dteEnd:Date){
    var dateDeb = this.formatDate(dteStrt);
    var dateFin = this.formatDate(dteEnd);
    var ms = moment(dateFin,"DD/MM/YYYY HH:mm").diff(moment(dateDeb,"DD/MM/YYYY HH:mm"));
    var d = moment.duration(ms);
    var s = Math.floor(d.asHours()) + moment.utc(ms).format(":mm:ss");
    return s;

  }

  testDateBeforeNow(dteStrt:Date,dteEnd:Date){
      var now = new Date();
      if( moment(dteStrt) <= moment(now) && moment(dteEnd) <= moment(now) ){
        return true;
      }else{
        return false;
      }
  }

  convertMinutesToHoursAndMinute(duree:number) {
    let days:number, hours:number, minutes:number;

    days = Math.floor(duree/1440);
    duree = duree%1440;

    hours = Math.floor(duree/60);
    duree = duree%60;

    minutes = duree;

    if (days>0) {
      return days + ' jours, ' + hours + ' heures, ' + minutes + ' minutes';
    }

    else {
      return hours + ' heures, ' + minutes + ' minutes';
    }
  }

  ShortconvertMinutesToHoursAndMinute(duree:number) {
    let days:number, hours:number, minutes:number;

    days = Math.floor(duree/1440);
    duree = duree%1440;

    hours = Math.floor(duree/60);
    duree = duree%60;

    minutes = duree;

    if (days>0) {
      return days + 'j ' + hours + 'h ' + minutes + 'm';
    }

    else {
      return hours + 'h ' + minutes + 'm';
    }
  }

}
