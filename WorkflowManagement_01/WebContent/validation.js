    function addUserValidation()  
    {  
    var uid = document.add_user.userid;  
    
    var fname=document.add_user.fname;
    var lname=document.add_user.lname;
    var sex=document.add_user.sex;
    var dob=document.add_user.dob;
    var address=document.add_user.address;
    var country=document.add_user.country;
    var phone=document.add_user.phone;
    var email=document.add_user.email;
    
    if(allLetter(fname))  
    {  
    if(allLetter(lname))  
    { 
    if(alphanumeric(address))  
    {   
    if(allLetter(country))  
    {   
    if(ValidateEmail(email))  
    {  
    if(validsex(sex))  
    {  
    }  
    }   
    }  
    }   
    }    
    return false;  
    }
    }

function userid_validation(uid,mx,my)  
{  
var uid_len = uid.value.length;  
if (uid_len == 0 || uid_len >= my || uid_len < mx)  
{  
alert("User Id should not be empty / length be between "+mx+" to "+my);  
uid.focus();  
return false;  
}  
return true;  
}  
function passid_validation(passid,mx,my)  
{  
var passid_len = passid.value.length;  
if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
{  
alert("Password should not be empty / length be between "+mx+" to "+my);  
passid.focus();  
return false;  
}  
return true;  
}  
function allLetter(uname)  
{   
var letters = /^[A-Za-z]+$/;  
if(uname.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('Alphabet characters only');  
uname.focus();  
return false;  
}  
}  
function alphanumeric(uadd)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(uadd.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('Alphanumeric characters only');  
uadd.focus();  
return false;  
}  
}  
function allnumeric(uzip)  
{   
var numbers = /^[0-9]+$/;  
if(uzip.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('Numeric characters only');  
uzip.focus();  
return false;  
}  
}  
function ValidateEmail(uemail)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(uemail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
//alert("You have entered an invalid email address!");  
//uemail.focus();  
return false;  
}  
} 
function validsex(sex)  
{   
//var letters = /[A-Za-z]+$/;  
if(sex.value.match('M') || sex.value.match('F'))  
{  
return true;  
}  
else  
{  
alert('You can be mail or');  
uname.focus();  
return false;  
}  
}  


function checkform(i){

	if(i==1){
	if(document.getElementById("prefix").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }

    if(document.getElementById("fname").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("lname").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("email").value=="" && ValidateEmail(document.getElementById("email").value) ){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields/Enter valid Email";
        return false;
    }
    else if(document.getElementById("sex").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("dob").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("date").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("address").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("country").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    else if(document.getElementById("phone").value==""){
        document.getElementById("mandatory").innerHTML="*You must fill in all fields";
        return false;
    }
    
    else 
        return true;  
	}
	else
		return true;
}

function checklogin(){
    if(document.getElementById("loginemail").value==""){
        document.getElementById("loginmandatory").innerHTML="*All fields mandatory";
        return false;}
    else if(document.getElementById("loginpass").value==""){
        document.getElementById("loginmandatory").innerHTML="*All fields mandatory";
        return false;}
    else 
        return true;
}