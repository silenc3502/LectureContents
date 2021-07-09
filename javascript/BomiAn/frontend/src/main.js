import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import GlobalComponent from './components/GlobalComponent.vue'

const app = createApp(App)

app.component(GlobalComponent.name, GlobalComponent)
.use(store).use(router).mount('#app')
