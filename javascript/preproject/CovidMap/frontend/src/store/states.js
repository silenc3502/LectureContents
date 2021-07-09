export default {
  idRules: [
    v => !!v || 'id를 입력해 주세요'
  ],
  passwordRules: [
    v => !!v || '비밀번호를 입력해 주세요'
  ],
  nickNameRules: [
    v => !!v || 'nickname을 입력해 주세요.',
    v => (v.trim() !== '') || 'nickname을 입력해 주세요'
  ],
  phoneRules: [
    v => !!v || 'phone을 입력해 주세요.',
    v => (v.trim() !== '') || 'phone을 입력해 주세요.',
    v => /^\d{3}-\d{3,4}-\d{4}$/.test(v) || 'phone 형식으로 작성해주세요. (000-0000-0000 or 000-000-0000)'
  ],
  emailRules: [
    v => !!v || '이메일을 작성해 주세요.',
    v => (v.trim() !== '') || '이메일을 작성해 주세요.',
    v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요.'
  ],
  titleRule: [
    v => !!v || '글 제목을 작성해 주세요.'
  ],
  contentsRule: [
    v => !!v || '글 내용을 작성해 주세요.'
  ],
  isLogin: false,
  loginInfo: null,
  boardList: [],
  board: null,
  map: null,
  markers: [],
  circle: null,
  centerMarker: null
}
