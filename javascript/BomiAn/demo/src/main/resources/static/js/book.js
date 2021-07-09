function Book (title, author, volume, price) {
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
}

var html = new Book("웹마스터", "Ko", "608", '38,000') ;
var youtube = new Book('하루만에 만드는 유튜브', 'Kim', '1068', '40,000');
var python = new Book('일주일만에 파이썬', 'Park', '352', '18,000');

var bookList = [html, youtube, python]

document.write("<h1>책 제목 살펴보기</h1>");

for(var i = 0; i < bookList.length; i++) {
    
    document.write("<p>" + bookList[i].title + "</p>");
    document.write("<p>" + bookList[i].author + "</p>");
    document.write("<p>" + bookList[i].volume + "</p>");
    document.write("<p>" + bookList[i].price + "</p>");
};