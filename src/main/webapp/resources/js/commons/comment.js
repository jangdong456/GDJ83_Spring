const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");
const openModal = document.getElementById("openModal");


getList(1);


function getList(page) {
    fetch("commentList?product_id="+commentButton.getAttribute("data-product-id")+"&page="+page, {
        method : "GET"
    })
    .then(res => res.text())
    .then(res => commentList.innerHTML=res)
}

let flag = true; //true : 댓글등록, false: 수정

openModal.addEventListener("click", ()=> {
    flag = true;
    commentButton.innerHTML="댓글등록";
    commentContents.value="";
})


let product_id = 0;

commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")) {
        flag = false;
        product_id = e.target.getAttribute("deta-delete-btn");
        // commentButton.click()
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        commentContents.value = c;
        commentButton.innerHTML="댓글수정";
    }
})

commentList.addEventListener("click", (e)=>{
    e.preventDefault();
    if(e.target.classList.contains("pn")) {
        let p = e.target.getAttribute("data-page-num");
        getList(p);
    }

    if(e.target.classList.contains("cd")) {
        let id = e.target.getAttribute("deta-delete-btn");

        fetch("commentDelte", {
            method :"POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body :"board_num="+id
        })
        .then(res=>res.text())
        .then(res => {
            res = res.trim();
            if(res>0) {
                alert("삭제성공");
                getList(1);
            } else {
                alert("삭제실패");
            }
        }).catch(() => {
            alert("오류발생");
        })
    }
})

// 댓글 등록 및 수정을 같은 메서드로 하기
commentButton.addEventListener("click", ()=>{
    let contents = commentContents.value
    
    if(contents == null || contents == ""){
        alert("댓글을 입력해주세요");
        return;
    }

    let url = "commentAdd";

    const form = new FormData(); //html에다가 form을 만들었다 의미 -> <form></form>
    form.append("board_contents", contents); // <input tpye="text" name ="board_contents" value="contents값"></input>
    form.append("product_id", commentButton.getAttribute("data-product-id"));
    form.append("board_num", product_id);
    form.append("board_num", 3); // 만약 board_num이 여러개다 똑같이 값만 넣어주면 된다. 예를들어 100개이상이면 for문 돌려서 append 시켜준다.

    let param ="board_contents="+contents+"&product_id="+commentButton.getAttribute("data-product-id");
    if(!flag) {

        console.log("수정 if문 ")

        url = "commentUpdate";
        param = "board_contents="+contents+"&board_num="+product_id

        fetch(url, {
            method: "POST",
            // headers:{
            //     "Content-type":"application/x-www-form-urlencoded"
            // },
            body : form
        })
        .then(res=> res.text())
        .then(res => {
            if(res > 0){
                alert("댓글 수정 성공");
                getList(1);
               
            } else {
                alert("댓글 수정 실패");
                
            }
        }).catch(()=> {
            alert("오류발생");
        });
        commentClose.click();
    }

    fetch(url , {
        method: "POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body : param
       
    })
    .then(res=>res.text())
    .then(res => {
        if(res>0) {
            alert("댓글 작성완료");
            getList(1);
        } else {
            alert("댓글 작성 실패");
        } 
    })
    .catch(() => {
        alert("오류발생");
    })
    commentContents.value = "";

    commentClose.click();
});

