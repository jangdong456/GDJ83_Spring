const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");



getList(1);


function getList(page) {
    fetch("commentList?product_id="+commentButton.getAttribute("data-product-id")+"&page="+page, {
        method : "GET"
    })
    .then(res => res.text())
    .then(res => commentList.innerHTML=res)
}


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

commentButton.addEventListener("click", ()=>{
    commentClose.click();
    let contents = commentContents.value

    fetch("commentAdd" , {
        method: "POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body :"board_contents="+contents+"&product_id="+commentButton.getAttribute("data-product-id")
       
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

});

