import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import path from 'path'

const resolve = (dir: string) => path.join(__dirname, dir)

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],
    resolve: {
        alias: {
            '@': resolve('src'),
            comps: resolve('src/components'),
            views: resolve('src/views')
        }
    },
    server: {
        //端口号
        port: 3002,
        //设为 true 时若端口已被占用则会直接退出，而不是尝试下一个可用端口
        strictPort: false,
        //服务器启动时自动在浏览器中打开应用程序,当此值为字符串时，会被用作 URL 的路径名
        open: true,
        //自定义代理规则
        proxy: {
            // 选项写法
            // "/api": {
            //   target: "http://www.baidu.com",
            //   changeOrigin: true,
            //   rewrite: (path) => path.replace(/^\/api/, ""),
            // },
        },
    }
})
