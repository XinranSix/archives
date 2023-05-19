<template>
	<view>
		<page-head :title="title"></page-head>
		<view class="uni-padding-wrap uni-common-mt">
			<view class="uni-hello-text">
				1.需要自定义基座运行
			</view>
			
			
		</view>
		<view class="uni-padding-wrap uni-common-mt">
			<button @tap="testToastShow">调用XToast弹窗</button>
		</view>
	</view>
	
</template>

<script>
	import { showToast } from '@/uni_modules/uts-toast'
	
	
	export default {
		
		data() {
			return {
				title:"XToast集成示例"
			}
		},
		methods:{
			testToastShow(){
				let ret = showToast();
				if(!ret){
					uni.showToast({
						icon:'none',
						title:'需要在自定义基座中运行'
					})
				}
			}
		}
		
	}
	
	
</script>

<style>
</style>