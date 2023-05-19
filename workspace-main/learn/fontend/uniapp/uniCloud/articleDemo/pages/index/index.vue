<template>
	<view class="home">
		<view class="content">
			<view @click="goToDetail(item._id)" class="item" v-for="item in listArr" :key="item._id">
				<view class="text">
					<view class="title">{{item.title}}</view>
					<view class="info">
						<text>{{item.author}}</text>
						<text>
							<uni-dateformat 
							:date="item.posttime" 
							format="MM-dd"
							:threshold="[60000, 3600000]"></uni-dateformat>
						</text>
						<!-- <text>删除</text> -->
					</view>
				</view>
				<view class="pic"><image mode="aspectFill" src="../../static/images/nopic.jpg"></image></view>
			</view>
		</view>
		<view class="goAdd" @click="goAdd">
			<uni-icons type="plusempty" size="30" color="withe"></uni-icons>
		</view>
	</view>
</template>

<script>
	// import uni-dateformat from '../../uni_modules/uni-dateformat/components/uni-dateformat/uni-dateformat.vue'
	export default {
		data() {
			return {
				listArr: []
			}
		},

		onLoad() {
			this.getData()
		},
		// 触底方法
		onReachBottom() {
			this.getData()
		},
		onPullDownRefresh() {
			// console.log(123)
			this.listArr = []
			this.getData()
		},
		methods: {
			getData() {
				uniCloud.callFunction({
					name: 'art_get_all',
					data: {
						skip: this.listArr.length
					}
				}).then((res) => {
					// console.log(res)
					// let oldList = this.listArr
					// let nsList = [...oldList, ...res.result.data]
					// this.listArr = nsList
					this.listArr = [...this.listArr, ...res.result.data]
					uni.stopPullDownRefresh()
				})				
			},
			goToDetail(e) {
				console.log(e)
				uni.navigateTo({
					url: '/pages/detail1/detail1?id=' + e
				})
			},
			goAdd() {
				uni.navigateTo({
					url: '/pages/add/add'
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
.home{
	.content{
		padding:30rpx;
		.item{
			display: flex;
			justify-content: space-between;
			padding:20rpx 0;
			border-bottom:1rpx solid #eee;
			.text{
				flex:1;
				display: flex;
				flex-direction: column;
				justify-content: space-between;
				padding-right: 20rpx;
				.title{
					font-size: 44rpx;
					color:#333;
					text-align: justify;
					text-overflow: -o-ellipsis-lastline;
					overflow: hidden;				
					text-overflow: ellipsis;		
					display: -webkit-box;			
					-webkit-line-clamp: 2;			
					line-clamp: 2;					
					-webkit-box-orient: vertical;					
				}
				.info{
					font-size: 28rpx;
					color:#888;
					text{
						padding-right: 20rpx;
					}
				}
			}
			.pic{
				width: 260rpx;
				height: 180rpx;
				image{
					width: 100%;
					height: 100%;
				}
			}
		}
	}

	.goAdd{
		width: 120rpx;
		height: 120rpx;
		background: #2B9939;
		color:#fff;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 50%;
		font-size: 50rpx;
		position: fixed;
		right: 60rpx;
		bottom:100rpx;
		box-shadow: 0 0 20rpx rgba(43,153,57,0.7);
	}
}
</style>