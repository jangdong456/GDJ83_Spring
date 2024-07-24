

const whis = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");



//Arrow function 화살표 함수 -> 불필요한 함수 이름을 만들기 귀찮아서 / fetch함수에서 Arrow function을 많이 사용함
// 쓰는법 () -> {}
// 하지만 코드가 한줄이면 중괄호 {} 생략할 수 있다.

// then  -> 호출의 결과물
//         fetch("./addWish?num=15&name=aa", {
//          method: "GET"
// 의 결과물을  .then((res)=>{}) res는 객체에 담는다 -> res객체명은 아무렇게 지어도 상관없지만 보통 res쓰는듯
whis.addEventListener("click", (e)=>{
    let id = whis.getAttribute("data-product-id"); // 방법1
    //console.log(e.target.getAttribute("data-product_id")); 방법2

    fetch("./addWish?product_id="+id, {
    method: "GET"
    })
    .then((res)=>{return res.text()})  //return 생략가능
    .then((res)=>{
       if(res>0) {
            let check = confirm("WishList 확인?");
            if(check){
                location.href="./wishList";
                
            }
       } else {
            alert("목록 추가 실패");
       }       
    })
    .catch(()=>{
        alert("오류발생");
    })
});


// whis.addEventListener("click", function(){
//     fetch("./addWish?num=15&name=aa", {
//         method: "GET"
       
//     });
// });