package constants;

public class APIEndpoints {

	    // STORE
	    public static final String STORE_INVENTORY = "/store/inventory";
	    public static final String STORE_ORDER = "/store/order";
	    public static final String STORE_ORDER_BY_ID = "/store/order/{orderId}";

	    // USER
	    public static final String USER_CREATE_LIST = "/user/createWithList";
	    public static final String USER_CREATE_ARRAY = "/user/createWithArray";
	    public static final String USER_CREATE = "/user";
	    public static final String USER_GET = "/user/{username}";
	    public static final String USER_UPDATE = "/user/{username}";
	    public static final String USER_DELETE = "/user/{username}";
	    public static final String USER_LOGIN = "/user/login";
	    public static final String USER_LOGOUT = "/user/logout";
	    
}
