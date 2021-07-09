function Book (title, author, volume, price) {
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
}

var html = new Book ('웹 마스터','Ko','608','38,000');
var youtube = new Book ('하루만에 만드는 유튜브', 'Kim', '1068', '40000');
var python = new Book ('일주일만에 파이썬', 'Park', '352', '18000');

var bookList = [html, youtube, python];

document.write ("<h1>땡땡서점 세일물품입니다!</h1>");

for ( var i =0; i < bookList.length; i++) {
    document.write("<p>"+ bookList[i].author + " 작가님의 " + bookList[i].title + " 를 "
                    + bookList[i].price + " 원에 판매합니다. " + " ( " + bookList[i].volume + " page ) "
                     + "</p>");

}