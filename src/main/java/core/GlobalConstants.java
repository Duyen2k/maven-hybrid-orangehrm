package core;

import java.io.File;

public class GlobalConstants {
    //System Info:
    public static final String PROJECT_PATH=System.getProperty("user.dir");
    public static final String OS_NAME=System.getProperty("os.name");

    //App Info User:
    public static final String DEV_USER_URL="";
    public static final String STAGING_USER_URL="";
    public static final String PRODUCT_USER_URL="";

    //App Info Admin:
    public static final String DEV_ADMIN_URL="";
    public static final String STAGING_ADMIN_URL="";
    public static final String PRODUCT_ADMIN_URL="";

    public static final String ADMIN_USER_NAME="";
    public static final String ADMIN_PASSWORD="";

    //Wait Infor
    public static final long SHORT_TIMEOUT =10;
    public static final long LONG_TIMEOUT =30;

    //Download/ Upload file (du
    public static final String UPLOAD_PATH=PROJECT_PATH + File.separator+ "uploadFiles"+File.separator;
    public static final String DOWNLOAD_PATH=PROJECT_PATH +File.separator+ "downloadFiles" + File.separator;

    //Retry Case Failed
    public static final int RETRY_NUMBER=3;

    //Browser Logs/Extension
    public static final String BROWSER_LOG_PATCH=PROJECT_PATH + "browserLogs";
    public static final String BROWSER_EXTENSION_PATCH=PROJECT_PATH + "browserExtensions";

    //HTML Report Folder
    public static final String REPORTNG_PATCH=PROJECT_PATH + "htmlReportNG";
    public static final String EXTENT_PATCH=PROJECT_PATH + "htmlExtent";
    public static final String ALLURE_PATCH=PROJECT_PATH + "htmlAllure";





}
