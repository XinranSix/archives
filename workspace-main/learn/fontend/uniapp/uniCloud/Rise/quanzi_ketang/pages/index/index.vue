<template>
	<view class="home">
		<view class="topnav">
			<u-tabs
				:list="navList"
				@click="clickNav"
				:activeStyle="{
					color: '#333',
					fontWeight: 'bold',
					transform: 'scale(1.08)'
				}"
				:inactiveStyle="{
					color: '#888',
					transform: 'scale(1)'
				}"
			></u-tabs>
		</view>

		<view class="loadingState" v-show="loadState"><u-skeleton rows="4" title loading></u-skeleton></view>

		<view class="content">
			<view class="item" v-for="item in dataList"><blog-item :item="item"></blog-item></view>
		</view>

		<view class="edit" @click="goEdit"><text class="iconfont icon-a-21-xiugai"></text></view>
	</view>
</template>

<script>
const db = uniCloud.database();
export default {
	data() {
		return {
			navList: [
				{
					name: '最新',
					type: 'publish_date'
				},
				{
					name: '热门',
					type: 'view_count'
				}
			],
			loadState: true,
			dataList: [],
			navAction: 0
		};
	},
	onLoad() {
		this.getData();
	},
	methods: {
		getData() {
			const artTemp = db
				.collection('quanzi_article')
				.field('title,user_id,description,picurls,comment_count,like_count,view_count,publish_date')
				.getTemp();
			let userTemp = db
				.collection('uni-id-users')
				.field('_id,username,nickname,avatar_file')
				.getTemp();
			db.collection(artTemp, userTemp)
				.orderBy(this.navList[this.navAction].type, 'desc')
				.get()
				.then(res => {
					// console.log(res);
					this.dataList = res.result.data
					this.loadState = false
				});
		},
		clickNav(e) {
			this.loadState = true
			// console.log(e)
			this.dataList = []
			this.navAction = e.index
			this.getData()
		},
		// 跳转至编辑页面
		goEdit() {
			uni.navigateTo({
				url: '/pages/edit/edit'
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.home {
	.topnav {
		margin-bottom: 30rpx;
	}
	.loadingState {
		padding: 30rpx;
	}
	.content {
		.item {
			padding: 30rpx;
			border-bottom: #f7f7f7 10rpx solid;
		}
	}
	.edit {
		width: 120rpx;
		height: 120rpx;
		background: #0199fe;
		border-radius: 50%;
		color: #fff;
		position: fixed;
		z-index: 100;
		bottom: 150rpx;
		right: 50rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		box-shadow: 0 0 20rpx rgba(1, 153, 254, 0.8);
		.iconfont {
			font-size: 50rpx;
		}
	}
}
</style>
