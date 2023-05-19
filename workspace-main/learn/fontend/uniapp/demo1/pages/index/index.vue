<template>
	<view class="out">
		<navigator url="../list/list">新闻列表</navigator>
		<navigator url="../about/about">关于</navigator>
		<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1672712472-37bfacf8d47a5e5ed20b0c33b3ca4efe.png" mode="" class="myimg"></image>
		
		<view class="box"></view>
		<view class="block"></view>
		<icon type="success" size="26"/>
		<view>uniapp</view>
		<view>web 前端開發</view>
		<text user-select>nodejs</text>
		<text space="ensp">vue          js</text>
		<scroll-view class="scroll" scroll-x scroll-y>
			<view class="group">
				<view class="item">
					111
				</view>
				<view class="item">
					222
				</view>
				<view class="item">
					333
				</view>
				<view class="item">
					444
				</view>
				<view class="item">
					555
				</view>
			</view>
		</scroll-view>
		<swiper class='swiper' circular autoplay duration="100" interval=300 indicator-dots indicator-color="#fff" indicator-active-color="green">
			<swiper-item class="item">
				<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/d3e66b4aba3d43928d458d9424e6fdd6.jpeg"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/d3e66b4aba3d43928d458d9424e6fdd6.jpeg"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/d3e66b4aba3d43928d458d9424e6fdd6.jpeg"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/d3e66b4aba3d43928d458d9424e6fdd6.jpeg"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/d3e66b4aba3d43928d458d9424e6fdd6.jpeg"></image>
			</swiper-item>
		</swiper>
		
	</view>
</template>

<script>
	export default {
		
	}
</script>

<style lang="scss">
.myimg{
	width: 260rpx;
	height: 260rpx;
}
.out {
	.box {
		width: 200px;
		height: 200px;
		background: pink;
	}
	.block {
		width: 750rpx;
		height: 200rpx;
		background: green;
	}
}

.scroll {
	border: 1px solid red;
	box-sizing: border-box;
	height: 220rpx;
	height: 100rpx;
	.group {
		white-space: nowrap;
		.item {
			width: 220rpx;
			height: 220rpx;
			background: royalblue;
			display: inline-block;
			margin-left: 10rpx;
		}
	}
}

.swiper {
	.item {
		
	}
}
</style>
