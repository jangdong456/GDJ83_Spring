
const wishDelte = document.getElementsByClassName("wishDelte");

console.log(wishDelte);
console.log("확인");

for(let w of wishDelte) {
    w.addEventListener("click", ()=>{
        let id = w.getAttribut("data-wish-id");
        alert(id);
        // w.parentNode.parentNode.remove(); // 지우는 방법 1
        // let del = w.getAttribute("data-del-id"); // 지우는 방법 2
        // document.getElementById(del).remove();
    });
};