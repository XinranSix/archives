<template>
	<view>
		<button @tap="testTencentMap"> 选择地图信息</button>
	</view>
	
</template>

<script>
	import { gotoTencentMapActivity } from "@/uni_modules/uts-tencentmap";
	export default {
		data() {
			return {
				title: '',
			}
		},
		methods: {
			
			testTencentMap:function(e){
				
			},
		}
	}
</script>

<style>
</style>