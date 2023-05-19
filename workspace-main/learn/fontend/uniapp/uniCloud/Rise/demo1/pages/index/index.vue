<template>
	<view class="content">
		<button @click="addClick()">新增</button>
	</view>
</template>

<script>
	const db = uniCloud.database()
	
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {
			db.collection('article').get().then(res => {
				console.log(res)
			})
		},
		methods: {
			addClick() {
				db.collection('cloudDemo').add({
					title: " sdfv "
				}).then(res => {
					console.log(res)
					uni.showToast({
						title: '添加成功',
						icon: 'success'
					})
				}).catch(err => {
					console.log(err.message)
					uni.showToast({
						title: err.message,
						icon: "none"
					})
				}) 
			},
			getData() {
			
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
