import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import DataView from '../views/DataView.vue'
import GraphView from '../views/GraphView.vue'
import RowDetail from '@/components/RowDetail.vue'  // <-- aggiungi questa importazione

const routes = [
  
  { path: '/', name: 'home', component: HomeView },
  { path: '/login', name: 'login', component: LoginView },
  { path: '/data', name: 'data', component: DataView },
  { path: '/graph', name: 'graph', component: GraphView } , 
  { path: '/rowdetail/:id', name: 'RowDetail', component: RowDetail } ,
  // Aggiungi questa riga per il componente RowDetail

]

const router = createRouter({
  redirect: '/login',
  history: createWebHashHistory(), // <-- cambia questo
  routes
})

export default router
