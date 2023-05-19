<template>
	<view class="detail">				
		<view v-if="loadState">		
			<view class="title">{{detail.title}}</view>
			<view class="info">
				<text>{{detail.author}}</text>
				<text>
					<uni-dateformat
					:date="detail.posttime" 
					format="yyyy年MM月dd日 hh:mm:ss"
					:threshold="[60000, 3600000]"></uni-dateformat>
				</text>
			</view>
			<view class="content">
				{{detail.content}}
			</view>
			<view class="btnGroup">
				<button size="mini" @click="goEdit">修改</button>
				<button type="warn" size="mini" @click="onRemove">删除</button>
			</view>		
		</view>
		<view v-else>
			<uni-load-more status="loading"></uni-load-more>
		</view>
	</view>
</template>

<script>
	let id1;
	export default {
	
		data() {
			return {
				detail: {},
				loadState: false,
				
			}
		},
		onLoad(e) {
			let {id} = e
			 // console.log(this.id)
			this.getDetail(id)
		},
		onShow() {
			console.log(this.detail._id)
			 this.getDetail(id1)
		},
		methods: {
			goEdit() {
				uni.navigateTo({
					url: '/pages/edit/edit?id=' + this.detail._id
				})
			},
			getDetail(id) {
				id1 = id
				uniCloud.callFunction({
					name: 'art_get_row',
					data: {
						id
					}
				}).then(res => {
					// console.log(res.result.data[0])
					this.detail = res.result.data[0]
					this.loadState = true
					uni.setNavigationBarTitle({
						title: this.detail.title
					})
				}).catch(() => {
					uni.showToast({
						icon: 'error',
						title: '参数有误'
					})
					setTimeout(() => {
						uni.reLaunch({
							url: '/pages/index/index'
						})
					}, 800)
				})
			},
			removeFun() {
				uniCloud.callFunction({
					name: 'art_remove_row',
					data: {
						id: this.detail._id
					}
				}).then(res => {
					console.log(res)
					uni.showToast({
						title: '删除成功'
					})
					setTimeout(() => {
						uni.reLaunch({
							url: '/pages/index/index'
						})
					}, 800)
				}) 
			},
			onRemove() {			
				uni.showModal({
					content: '是否确认删除',
					success: res => {
						// console.log(res)
						if (res.confirm) {
							this.removeFun()
						}
					}
				})	
			}
		}
	}
</script>

<style lang="scss" scoped>
.detail {
	padding: 30rpx;
	.title {
		font-size: 50rpx;
		color: #000;
		text-align: justify;
		line-height: 1.4em;
	}
	.info {
		font-size: 30rpx;
		color: #666;
		padding: 30rpx 0 60rpx;
		text {
			padding-right: 30rpx;
		}
	}
	.content {
		font-size: 36rpx;
		line-height: 1.7em;
	}
	.btnGroup {
		padding: 50rpx 0;
		button {
			margin-right: 30rpx;
		}
	}
}
</style>
