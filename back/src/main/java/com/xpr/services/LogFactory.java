package com.xpr.services;


import java.io.IOException;

import com.xpr.dao.helper.XprBaseModel;

public interface LogFactory {

    String CREATE = "CREATE";
    String UPDATE = "UPDATE";
    String DELETE = "DELETE";
    String READ = "READ";

    void createLog(String action, XprBaseModel subject) throws IOException;
}
