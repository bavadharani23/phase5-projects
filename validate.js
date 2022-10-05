function validateLogin(){
    //alert("hello");
    var email=document.getElementById("n1").value;
    let password=document.getElementById("n2").value;
    if(email.length==0){
        alert("plz enter email id")
        return false;
    }else if(password.length==0){
        alertt("plz enter the password")
        return false;
    }else if(email=="raj@gmail.com" && password=="123"){
        alert("successfully login");
        return true;
    }else {
        alert("failure try one again");
        return false;
        
    }
        
}