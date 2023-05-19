<template>
	<view class="home">
		<view class="out">
			<view class="row">姓名：{{}}</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				listArr: [],
				userArr: []
			}
		},
		onLoad() {
			this.getData()
		},
		methods: {
			getData() {
				uniCloud.callFunction({
					name: 'cloudDemoGet'
				}).then((res) => {
					console.log(res)
				})
			}
		}
	}
</script>

<style lang="scss">
.out {
	padding: 30rpx;
	.row {
		border-bottom: 1px solid #ccc;
		padding: 20rpx 0;
	}
}
</style>
