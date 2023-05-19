<template>
	<view>
		<page-head :title="title"></page-head>
		<view class="uni-padding-wrap uni-common-mt">
			<view class="uni-hello-text">
				1. 腾讯定位sdk需在腾讯地图官网申请key。https://lbs.qq.com/mobile/androidMapSDK/
				developerGuide/getKey。
			</view>
			<view class="uni-hello-text">
				2. 将key配置在uts插件uts-tencentgeolocation/utssdk/app-android/AndroidManifest.xml中。
			</view>
			
		</view>
		<view class="uni-btn-v uni-common-mt">
			<button type="primary"  @tap="checkLocationPermission">请求定位权限</button>
			<button type="primary"  @tap="testGetlocation">腾讯地图获取定位（需自定义基座）</button>
		</view>
	</view>
</template>

<script>
	 import {requestPremission,getLocation} from "@/uni_modules/uts-tencentgeolocation";
	 
	export default {
		data() {
			return {
				title: '腾讯定位SDK集成示例',
			}
		},
		methods: {
			
			checkLocationPermission:function(e){
				requestPremission();
			},
			testGetlocation:function(e){
				
				let startRet = getLocation({
					geocode:true,
					success:function(response){
						console.log(response);
						var addressDesc = response.name + '-' + response.address
						uni.showToast({
							title:'执行结果:' + addressDesc,
							icon:'none'
						});
					},
					fail:function(msg) {
						uni.showToast({
							title: msg,
							icon:"none"
						})
					}
				})
				
				if(!startRet){
					uni.showToast({
						title:'定位启动失败，请检查配置',
						icon:'none'
					});
				}
				
			},
		}
	}
</script>

<style>

</style>
