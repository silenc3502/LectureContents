package com.example.demo.controller.board;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
// Controller vs RestController의 차이점은 딱 하나다.
// Controller는 HTML을 파싱하는 반면
// RestController는 json을 파싱한다.
@RestController
public class SixthController {

    @GetMapping("/jsonTest")
    public String getJsonTest () {

        return "I'm JSON!!!!";
    }

    @GetMapping("/jsonKeyValueTest")
    public String getJsonKeyValueTest () {
        String jsonString = "{\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}";

        // JSON 파싱
        JSONObject jObj = new JSONObject(jsonString);
        String title = jObj.getString("title");
        Boolean draft = jObj.getBoolean("draft");
        Integer star = jObj.getInt("star");

        log.info("title: " + title + ", draft: " + draft + ", star: " + star);

        return jsonString;
    }

    @GetMapping("/jsonMultiObjectTest")
    public String getJsonMultiObjectTest () {
        String jsonString = "{" +
                "\"movie1\": {" +
                "\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "\"movie2\": {" +
                "\"title\": \"code monkey\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);

        JSONObject movie1Obj = jObj.getJSONObject("movie1");

        log.info("movie1" + movie1Obj.toString() +
                "\ntitle:" + movie1Obj.getString("title") +
                ", draft: " + movie1Obj.getBoolean("draft") +
                ", star: " + movie1Obj.getInt("star"));

        JSONObject movie2Obj = jObj.getJSONObject("movie2");

        log.info("movie2" + movie2Obj.toString() +
                "\ntitle:" + movie2Obj.getString("title") +
                ", draft: " + movie2Obj.getBoolean("draft") +
                ", star: " + movie2Obj.getInt("star"));


        return jsonString;
    }

    //현재 시점까지의 json처리는 향후 Vue에서 AXIOS라는 것을 사용하며 모두처리가될것임
    //한가지 차이가 있다면 나중에 python과 연동할 때
    //Spring의 Requester을 통해서 Spring 자체가 Client가 되어야함
    //그 시점에서는 Spring이 직접 JSON을 처리할 필요가 있음
    //Python Server에 요청을 넣어
   @GetMapping("/jsonArrayTest")
    public String getJsonPowerTest () {
        String jsonString = "{" +
                "\"movies\": [" +
                "{" +
                "\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "{" +
                "\"title\": \"code monkey\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "{" +
                "\"title\": \"monkey magic\", " +
                "\"draft\": false, " +
                "\"star\": 4.7" +
                "}" +
                "]" +
                "}";

        // JSON 배열 파싱
        JSONObject jObj = new JSONObject(jsonString);
        JSONArray jArr = jObj.getJSONArray("movies");

        // 루프를 돌며 JSON 배열의 모든 정보를 출력함
        for (int i = 0; i < jArr.length(); i++) {
            JSONObject obj = jArr.getJSONObject(i);

            String title = obj.getString("title");
            Boolean draft = obj.getBoolean("draft");
            Float star = obj.getFloat("star");

            log.info("title: " + title + ", draft: " + draft + ", star: " + star);
        }

        return jsonString;
    }
}