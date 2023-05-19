<template>
	<view class="home">		
		<scroll-view scroll-x class="navscroll">
			<view class="item" v-for="item in 10">国内</view>
		</scroll-view>
		<view class="content">
			<view class="row" v-for="item in 10">
				<newsbox></newsbox>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style lang="scss" scoped>
.home {
	.navscroll {
		height: 100rpx;
		background: #F7F8FA;
		white-space: nowrap;
		/deep/ ::-webkit-scrollbar {
			width: 4px !important;
			height: 1px !important;
			overflow: auto !important;
			background: transparent !important;
			-webkit-appearance: auto !important;
			display: block;
		}
		.item {
			font-size: 40rpx;
			display: inline-block;
			line-height: 100rpx;
			padding: 0 30rpx;
			color: #333;
		}
	}
	
	.content {
		padding: 30rpx;
		.row {
			border-bottom: 1rpx dashed dotted #efefefe;
			padding: 15rpx 0;
		}
	}
}
</style>
