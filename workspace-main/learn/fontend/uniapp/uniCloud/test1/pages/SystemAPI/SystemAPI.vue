<template>
	<view>
		<page-head :title="title"></page-head>
		<uni-collapse>
			<uni-collapse-item title="设备相关" :border="false">
				<uni-list>
					<uni-list-item @tap="testGetBatteryCapacity" title="获取电池电量" class="itemButton" :clickable="true"/>
				</uni-list>
			</uni-collapse-item>
		</uni-collapse>
		
		<uni-collapse>
			<uni-collapse-item title="系统事件" :border="false">
				<uni-list>
					<uni-list-item @tap="gotoScreenListen" title="监听系统截屏" class="itemButton" :clickable="true" link/>
				</uni-list>
			</uni-collapse-item>
		</uni-collapse>
		
		<uni-collapse>
			<uni-collapse-item title="android平台" :border="false">
				<uni-list>
					<uni-list-item @tap="testGotoDemoActivity" title="自定义activity(需自定义基座)" class="itemButton" :clickable="true" link/>
				</uni-list>
			</uni-collapse-item>
		</uni-collapse>
		
		
	</view>
</template>
<script>
	import gotoDemoActivity from "@/uni_modules/uts-nativepage";
	import getBatteryInfo from "@/uni_modules/uni-getbatteryinfo";
	

	export default {
		data() {
			return {
				title: '系统API示例',
				
			}
		},
		onUnload: function() {},
		methods: {
			testGetBatteryCapacity() {
				getBatteryInfo({
					success(res) {
						uni.showToast({
							title: "当前电量：" + res.level + '%',
							icon: 'none'
						});
					}
				})
			},
			gotoScreenListen(){
				uni.navigateTo({
					url:'/pages/SystemAPI/ScreenListen/screenlisten'
				})
			},

			testGotoDemoActivity() {
				gotoDemoActivity();
			},

		}
	}
</script>

<style>
.screenImage{
	width: 100%;
	height: 380px;
}

</style>
