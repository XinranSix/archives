import {InjectionKey} from "vue";
import {createStore, Store} from "vuex";

export interface State {

}

export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
    state() {
        return {
            // 存储token
            Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : ''
        }
    },
    mutations: {
        // 修改token，并将token存入localStorage
        changeLogin(state, user) {
            // state.Authorization = user.Authorization;
            localStorage.setItem('Authorization', user.Authorization);
        }

    }
})
