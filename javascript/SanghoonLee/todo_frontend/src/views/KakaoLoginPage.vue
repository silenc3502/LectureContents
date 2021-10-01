<template>
    <v-container>
        <ul>
            <li onclick="kakaoLogin()">
                <a href="javascript:void(0)">
                    <span>카카오 로그인</span>
                </a>
            </li>
        </ul>
    </v-container>
</template>

<script>

import axios from 'axios'
// import '@/kakao/kakao.js'

export default {
    name: 'PythonLoginTestPage',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            axios.post('http://localhost:5000/login', { userId: id, password: pw })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + JSON.stringify(res.data))
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}

</script>