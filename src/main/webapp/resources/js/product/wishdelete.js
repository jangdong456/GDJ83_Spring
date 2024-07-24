
// 배열
const wishDelete = document.getElementsByClassName("wishDelete");
const deleteAll = document.getElementById("deleteAll");

const checkAll = document.getElementById("checkAll");
const checkEach = document.getElementsByClassName("checkEach");

deleteAll.addEventListener("click", () => {
    let url = "wishDelete?";
    let test = [];

    for(let c of checkEach) {
        if(c.checked) {
            let id= c.getAttribute("data-wish-id")
            url = url +"product_id=" + id + "&";
            test.push(c.getAttribute("data-del-id"));
        }
    }
    url = url.substring(0, url.length-1);


    fetch(url, {
        method: "GET"
    })
    .then(res => res.text())
    .then(res => {
        res = res.trim();
        if(res>0){
            for(let ele of test) {
                document.getElementById(ele).remove();
            }
            alert("여러개 삭제 성공");
        } else {
            alert("여러개 삭제 실패");
        }
    }).catch(() => { alert("원인불명??")});
})



checkAll.addEventListener("click", ()=> {
    for(let c of checkEach){
        c.checked = checkAll.checked;
    }
})

for(let c of checkEach){
    c.addEventListener("click", ()=> {
        let flag = true;
        // check = true
        for(let check of checkEach){
            if(!check.checked) { // 체크박스 눌러진 애들 false 
                flag = false;
                break;
            }
        }
        checkAll.checked = flag;
    })
   
}



for(let w of wishDelete) {
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        alert(id);

        fetch("./wishDelete?product_id="+id, {
            method: "GET"
        }).then((res)=>{return res.text()}) // 서버에서 아직 json이 아닌 html로 응답을 보내서 text()함수를 사용하고 있다.
          .then((res)=>{  // 서버에서 지금은 응답 값을 숫자 를 보냄

            res = res.trim(); // 공백이 올 수 있어서

            if(res>0){

                w.parentNode.parentNode.remove(); // 지우는 방법 1
                // let del = w.getAttribute("data-del-id"); // 지우는 방법 2
                // document.getElementById(del).remove();
            } else {
                alert("삭제 오류발생");
            }
        }).catch(()=>{alert("삭제 오류발생@")}); // 성공도 아니고 실패도 아니고  클라이언트나 서버측에서 에러가 발생할때
        
    });
};