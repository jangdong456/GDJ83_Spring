/**
 * 
 */
 
  // let, const
 //함수 선언
 //function 함수명(매개변수 선언){return}
 
const btn = document.getElementById("btn");
const userName = document.getElementById("userName");
const password = document.getElementById("password");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const ch = document.getElementsByClassName("ch");//배열 형식
const frm = document.getElementById("frm");

const passwordCheck = document.getElementById("passwordCheck");
//  blur : focus 잃었을 때
//  blur 이벤트가 발생할때 아이디가 중복인지 아닌지
//  중복이면은 아이디 작성한 값 지워주기

passwordCheck.addEventListener("change", function(){
    if(password.value != passwordCheck.value){
        passwordCheck.value="";
        passwordCheck.focus();
        pserror.innerHTML="password가 틀립니다.";
    } else {
        pserror.innerHTML="";
        passworderror.innerHTML="";
    }
 })

password.addEventListener("change", function(){
    if(password.value != passwordCheck.value){
        pserror.innerHTML="password가 틀립니다.";
        passwordCheck.focus();
    } else {
        pserror.innerHTML="";
        passworderror.innerHTML="";
    }
 })

btn.addEventListener("click", function (){

    if(userName.value==''){
        alert('ID를 입력하세요.');
        userName.focus();
        return;
    }

    if(password.value==''){
        passworderror.innerHTML="password는 필수입니다.";
        password.focus();
        return;
    } else if (password.value.length<8) {
        passworderror.innerHTML="password는 8자가 넘어야합니다.";
        password.focus();
        return;
    }

    if(name.value==''){
        name.innerHTML="이름 입력 하세요.";
        name.focus();
        return;
    }

    if(email.value==''){
        email.innerHTML="email 입력 하세요.";
        email.focus();
        return;
    }

    if(phone.value==''){
        phone.innerHTML="phone 입력 하세요.";
        phone.focus();
        return;
    }

    if(address.value==''){
        address.innerHTML="address 입력 하세요.";
        address.focus();
        return;
    }
})
 
