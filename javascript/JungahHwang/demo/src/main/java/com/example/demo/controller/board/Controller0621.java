package com.example.demo.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// Controller는 HTML을 파싱하는 반면 RestController는 json을 파싱함

public class Controller0621 {
    @GetMapping("/jsonTest")
    public String getJsonTest() {
        return "I'm JSON!!";
    }
    @GetMapping("/jsonKeyValue")
    public String getJsonKeyValue (){
        // json format: key + value, key + value(모든 json데이터는 아래와 같은 모양임)
        String jsonString = "{\"title\":\"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}";

        // Json 파싱
        JSONObject jObj = new JSONObject(jsonString);
        String title = jObj.getString("title");
        Boolean draft = jObj.getBoolean("draft");
        Integer star = jObj.getInt("star");

        // json 형태로 전달된 데이터를 해석을 해서 출력함
        log.info("title: " + title + ", draft: " + draft + ", star: " + star);

        return jsonString;
    }
    @GetMapping("/jsonMultiObject")
    public String getJsonMultiObject(){
        String jsonString = "{" +
                "\"movie1\": {" +
                    "\"title\":\"hihi\", " +
                    "\"draft\": false, " +
                    "\"star\": 5" +
                    "}, " +
                "\"movie2\": {" +
                    "\"title\":\"code monkey\", " +
                    "\"draft\": false, " +
                    "\"star\": 5" +
                    "}, " +
                "}";
        // json 내에 Object 형식이 구성된 경우의 파싱
        JSONObject jObj = new JSONObject(jsonString);

        JSONObject movie1Obj = jObj.getJSONObject("movie1");
        log.info("movie1: " + movie1Obj.toString() +
                "\ntitle: " + movie1Obj.getString("title") +
                ", draft: " + movie1Obj.getBoolean("draft") +
                ", star: " + movie1Obj.getInt("star"));

        JSONObject movie2Obj = jObj.getJSONObject("movie2");
        log.info("movie2: " + movie2Obj.toString() +
                "\ntitle: " + movie2Obj.getString("title") +
                ", draft: " + movie2Obj.getBoolean("draft") +
                ", star: " + movie2Obj.getInt("star"));

        return jsonString;
    }
    @GetMapping("/jsonArray")
    public String getJsonArray(){
        String jsonString = "{" +
                "\"movies\": " +
                    "[" +
                        "{" +
                            "\"title\":\"hihi\", " +
                            "\"draft\": false, " +
                            "\"star\": 5" +
                        "}, " +
                        "{" +
                            "\"title\":\"code monkey\", " +
                            "\"draft\": false, " +
                            "\"star\": 5" +
                        "}, " +
                        "{" +
                            "\"title\":\"monkey magic\", " +
                            "\"draft\": false, " +
                            "\"star\": 4.5" +
                        "}, " +
                    "]" +
                "}";

        // json에 배열 파싱
        JSONObject jObj = new JSONObject(jsonString);
        JSONArray jArr = jObj.getJSONArray("movies");

        // 루프를 돌며 json 배열의 모든 정보를 출력
        for(int i = 0; i < jArr.length(); i++){
            JSONObject obj = jArr.getJSONObject(i);

            String title = obj.getString("title");
            Boolean draft = obj.getBoolean("draft");
            Float star = obj.getFloat("star");

            log.info("title: " + title + ", draft: " + draft + ", star: " + star);
        }
        return jsonString;
    }

}

























