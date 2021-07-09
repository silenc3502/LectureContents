# 리눅스 및 유닉스(맥)에서 자주 사용하는 명령어들

## 특정 파일 포맷을 가진 파일들을 한 번에 싹 다 옮기기

상황: 현재 디렉토리 /test  
현재 파일들 1.pdf, 2.pdf, 3.pdf, 4.pdf, 5.pdf, 6.pdf, test.dwg, architecture.dwg,   
7.pdf, 8.pdf, 9.pdf, 10.pdf, 11.pdf, 12.pdf, 13.pdf, 14.pdf, 15.pdf, 16.pdf  

옮기고자 하는 디렉토리 /test/summary  

```make
cd summary
mv ../*.pdf ./
ls
ls ..

여기서 *.pdf가 모든 pdf 포맷을 의미함
```
