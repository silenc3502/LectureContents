function Book (title, author, volume, price) {
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
    // this.url = url;

}

var html = new Book('웹 마스터', 'Ko', '608', '38,000' '/lists');  // 누르게되면 /lists url로 GetMapping하게 된다.
var youtube = new Book('하루만에 만드는 유튜브', 'Kim', '1068', '40,000' '/member/register'); //위와 동일
var python = new Book('일주일만에 파이썬', 'Park', '352', '18000', '#');

var bookList = [html, youtube, python];

document.write("<h1>책 제목으로 살펴보기!</h1>");

for (var i = 0; i < bookList.length; i++) {

    document.write("<p>" + "책 제목: " + bookList[i].title + "<br>" + "저자: " + bookList[i].author +
                    "<br>" + "페이지 수: " +  bookList[i].volume + "<br>" + "가격: " + bookList[i].price + "</p>");

    // 만약 url맵핑을 통해 제목을 클릭시 내용이 나오게 하려면 a href 태그를 추가하고
    // 위에 url을 따로 맵핑시켜야 한다.
    //document.write("<p><a href= '" + bookList[i].url + "'>" + "책 제목: " + bookList[i].title + "<br>" + "저자: " + bookList[i].author +
                                        // <br>" + "페이지 수: " +  bookList[i].volume + "<br>" + "가격: " + bookList[i].price + "</p>");


}






