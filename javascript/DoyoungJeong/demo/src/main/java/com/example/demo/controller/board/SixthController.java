package com.example.demo.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //json을 파싱하는 컨트롤러

public class SixthController {

    @GetMapping("/jsonTest")
    public String getJasonTest() {

        return "나는 json이다!";
    }

    @GetMapping("/jsonKeyValueTest")
    public String getJsonKeyValueTest() {
        String jsonString = "{\"title\": \"hihi\"," +
                "\"draft\": false," +
                "\"star\": 5" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);
        String title = jObj.getString("title");
        Boolean draft = jObj.getBoolean("draft");
        Integer star = jObj.getInt("star");

        log.info("title: " + title + ", draft: " + draft + ", star");

        return jsonString;
    }

    @GetMapping("/jsonMultiTest")
    public String getJsonMultiTest() {
        String jsonString = "{" +
                "\"movie1\": {" + //movie1이 키값, 그 안의 값이 value이고, value에서 title, draft, star가 다시 key값을 가진다.
                "\"title\": \"KingKong\", " +
                "\"draft\": true, " +
                "\"star\": 4" +
                "}, " +
                "\"movie2\": {" +
                "\"title\": \"KingKong\", " +
                "\"draft\": false, " +
                "\"star\": 3" +
                "}" +
                "}";

        return jsonString;
    }

    @GetMapping("/jsonArrayTest")
    public String getJsonArrayTest() {
        String jsonString = "{" +
                "\"movies\": [" +
                        "{" +
                            "\"title\": \"matrix\", " +
                            "\"draft\": false, " +
                            "\"star\": 5" +
                        "}, " +
                        "{" +
                            "\"title\": \"matrix\", " +
                            "\"draft\": false, " +
                            "\"star\": 5" +
                        "}, " +
                        "{" +
                            "\"title\": \"matrix\", " +
                            "\"draft\": false, " +
                            "\"star\": 5" +
                        "}" +
                    "]" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);
        //String으로 되어있는 문장을 JSONObject에 넣어 json형식의 데이터로 만들고,
        JSONArray jArr = jObj.getJSONArray("movies");
        //json형식으로 만들어진 jobj를 JSONArray에 넣어 jobj안의 배열을 추출한다.

        for(int i=0; i<jArr.length(); i++) {
            JSONObject obj = jArr.getJSONObject(i);
            //새로 선언된 obj는 for문을 돌면서 위 jobj에서 추출된 그 안의 배열 jArr의 값을 차례대로 받을것이다.

            String title = obj.getString("title");
            Boolean draft = obj.getBoolean("draft");
            Integer star = obj.getInt("star");
            //for문을 돌면서 obj가 갱신되며 갖고있던 title, draft, star값을 생성하고,

            log.info("title: " + title + ", draft: " + draft + ", star");
            //log문으로 출력한다.
        }

        return jsonString;
    }

    /* {
        "movies": [
        {
            "title": "matrix",
                "draft": "false",
                "star": "5"
        },
        {
            "title": "matrix",
                "draft": "false",
                "star": "5"
        },
        {
            "title": "matrix",
                "draft": "false",
                "star": "5"
        }
    ]
    }  http://sample.bmaster.kro.kr/contacts의 jsonInput에 집어넣을 때는 위 형식대로 집어넣으면 작동한다. */

}

