<template>
	<view class="detail">
		<view class="container">
						                                                                    	
				<view v-if="loadState">
					<u-skeleton
						rows="5"
						title
						loading
					></u-skeleton>
				</view>
				<view v-else>
					<view class="title">{{dateilObj.title}}</view>
					<view class="userinfo">
						<view class="avatar">
							<image  :src="dateilObj.user_id[0].avatar_file ? dateilObj.user_id[0].avatar_file.url : '../../static/images/user-default.jpg'" mode="aspectFill"></image>
						</view>
						<view class="text">
							<view class="name">{{ dateilObj.user_id[0].nickname ? dateilObj.user_id[0].nickname : dateilObj.user_id[0].username}}</view>
							<view class="small"><uni-dateformat :date="dateilObj.publish_date" format="yyyy年MM月dd hh:mm:ss"></uni-dateformat> · 发布于{{dateilObj.province}}</view>
						</view>
					</view>
					<view class="content">
						<!-- <view v-html="data.content"></view> -->
						<u-parse :content="dateilObj.content" :tagStyle="tagStyle"></u-parse>
					</view>
					
					<view class="like">
						<view class="btn" @click="clickLike" :class="dateilObj.isLike ? 'active' : ''">
							<text class="iconfont icon-good-fill"></text>
							<text v-if="dateilObj.like_count > 0">{{dateilObj.like_count}}</text>
						</view>								
						<view class="users">					
							<image src="../../static/images/user.jpg" mode="aspectFill" ></image>
						</view>				
						<view class="text"><text class="num">{{dateilObj.view_count}}</text>人看过</view>
					</view>
					
				</view>
			
		</view>
	</view>
</template>

<script>
	const db = uniCloud.database()
	const utilsObj = uniCloud.importObject('utilsObj', {
		customUI: true // 取消自动展示的交互提示界面
	})
	export default {
		data() {
			return {
				artId:'',
				loadState: true,
				tagStyle: {
					p:"line-height:1.7em;font-size:16px;padding-bottom:10rpx",
					img:"margin:10rpx 0"
				},
				dateilObj: null
			}
		},
		onLoad(e) {
			if (!e.id) {
				this.errFun()
				return
			}
			
			this.artId = e.id
			this.getData()
			this.readUpdate()
		},
		methods: {
			async clickLike() {
				
				let time = Date.now()
				if (time - this.likeTime < 2000) {
					uni.showToast({
						title: '操作太频繁，请稍后...',
						icon: 'none'
					})
					return
				}
				this.likeTime = time
				this.dateilObj.isLike ? this.dateilObj.like_count-- : this.dateilObj.like_count++
				console.log(this.dateilObj.like_count)
				this.dateilObj.isLike = !this.dateilObj.isLike
				
				this.likeFun()
				// return 
				
			},
			// 点赞操作数据库的方法
			async likeFun() {
				let count = await db.collection('quanzi_like')
					.where(`article_id =='${this.artId}' && user_id==$cloudEnv_uid`).count()
				console.log(count)
				if (count.result.total) {
					db.collection('quanzi_like').where(`article_id =='${this.artId}' && user_id==$cloudEnv_uid`).remove()
					
					utilsObj.operation('quanzi_article', 'like_count', this.artId, -1)
				} else {
					db.collection('quanzi_like').add({
						article_id: this.artId
					})
					utilsObj.operation('quanzi_article', 'like_count', this.artId, 1)
				}
			},
			readUpdate() {
				utilsObj.operation('quanzi_article', 'view_count', this.artId, 1).then(res => {
					
				})
			},
			errFun() {
				uni.showToast({
					title: '参数有误',
					icon: 'none'
				})
				setTimeout(() => {
					uni.reLaunch({
						url: '/pages/index/index'
					})
				}, 1000)
			},
			getData() {
				let artTemp = db.collection('quanzi_article').where(`_id=="${this.artId}"`).getTemp()
				let userTemp = db.collection('uni-id-users').field("_id,username,nickname,avatar_file").getTemp()
				let likeTemp = db.collection('quanzi_like').where(`article_id =='${this.artId}' && user_id==$cloudEnv_uid`).getTemp()
				
				db.collection(artTemp, userTemp, likeTemp).get({
					getOne: true
				}).then(res => {
					console.log(res)
					if (!res.result.data) {
						this.errFun()
						return
					}
					this.loadState = false
					let isLike = res.result.data._id.quanzi_like.length ? true : false
					res.result.data.isLike = isLike
					this.dateilObj = res.result.data
					uni.setNavigationBarTitle({
						title: this.dateilObj.title
					});
				}).catch(err => {
					this.errFun()
				})
			}
		}
	}
</script>

<style lang="scss">
.detail {
	background: #f8f8f8;
	min-height: calc(100vh - var(--window-top));	
	.container{
		padding:30rpx;	
		background: #fff;
		.title{
			font-size: 46rpx;
			color:#333;
			line-height: 1.4em;
			font-weight: 600;
		}
		.userinfo{
			padding:20rpx 0 50rpx;
			display: flex;
			align-items: center;
			.avatar{
				width: 60rpx;
				height: 60rpx;
				padding-right: 15rpx;
				image{
					width: 100%;
					height: 100%;
					border-radius: 50%;
				}
			}
			.text{
				font-size: 28rpx;
				color:#555;
				.small{
					font-size: 20rpx;
					color:#999;
				}
			}
		}
		.content{
			
		}
		.like{
			display: flex;
			flex-direction: column;
			align-items: center;
			padding:80rpx 50rpx 50rpx;
			.btn{
				width: 260rpx;
				height: 120rpx;
				background: #e4e4e4;
				border-radius: 100rpx;
				color:#fff;
				display: flex;
				justify-content: center;
				align-items: center;
				flex-direction: column;
				font-size: 28rpx;
				.iconfont{
					font-size: 50rpx;
				}
				&.active{
					background: #0199FE;
				}
			}
			.text{
				font-size: 26rpx;
				color:#666;				
				.num{
					color:#0199FE
				}
				.spot{
					padding:0 10rpx;
				}
			}
			.users{
				display: flex;
				justify-content: center;
				padding:30rpx 0;
				image{
					width: 50rpx;
					height: 50rpx;
					border-radius: 50%;
					border:3px solid #fff;
					margin-left:-20rpx;
				}
			}
		}
		
	}
}
</style>
