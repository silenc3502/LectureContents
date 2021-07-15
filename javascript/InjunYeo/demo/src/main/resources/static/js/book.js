function Book(title,author,volume,price){
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
}

var html = new Book("웹 마스터","ko","608","38000");
var youtube = new Book("유튜브","ku","1068","35000");
var python = new Book("파이썬","park","352","18000");


//bookList:[{} {} {}]
//html:{title:~~~,author:~~~,volume:~~~~,price:~~~
var bookList=[html,youtube,python];

document.write("<h1> 책 제목으로 살펴보기!</h1>");

for(var i = 0;i<bookList.length;i++){
    document.write("<p>"+bookList[i].title+bookList[i].author+bookList[i].price+"</p>");



}