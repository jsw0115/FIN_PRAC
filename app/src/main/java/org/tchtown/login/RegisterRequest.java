package org.tchtown.login;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest  extends StringRequest{
    final static private String URL = "http://192.168.0.9/UserRegister.php";
    private Map<String,String> parameters;

    public RegisterRequest(String userID, String userPassword, String userGrade, String userMajor, String userEmail, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
        parameters.put("userGrade",userGrade);
        parameters.put("userMajor",userMajor);
        parameters.put("userEmail",userEmail);
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
