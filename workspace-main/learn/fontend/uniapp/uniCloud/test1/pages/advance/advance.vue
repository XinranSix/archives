<template>
	<view>
		<page-head :title="title" accordion></page-head>


		<uni-collapse accordion>
			<uni-collapse-item title="延迟任务" :border="false">

				<uni-list>
					<uni-list-item @tap="testTimer" title="开启延迟任务"  :clickable="true">
					</uni-list-item>
				</uni-list>
			</uni-collapse-item>

			<uni-collapse-item title="定时任务" :border="false">

				<uni-list>
					<uni-list-item @tap="testInterval" title="开启定时任务"  :clickable="true">
					</uni-list-item>
					<uni-list-item @tap="testClearInterval" title="关闭定时任务" :clickable="true">
					</uni-list-item>
				</uni-list>
			</uni-collapse-item>
			<uni-collapse-item title="语法示例" :border="false">
				<uni-list>
					<uni-list-item @tap="testSyntax" title="进阶语法示例" :clickable="true" link>
					</uni-list-item>
				</uni-list>
			</uni-collapse-item>
			<uni-collapse-item title="资源加载示例" :border="false">
				<uni-list>
					<uni-list-item @tap="gotoResourceDemo" title="图片加载示例" :clickable="true" link>
					</uni-list-item>
				</uni-list>
			</uni-collapse-item>
			<uni-collapse-item title="android平台示例" :border="false">

				<uni-list>

					<uni-list-item @tap="testLifecyle" title="activity生命周期监听" :clickable="true" link />
					<uni-list-item @tap="testAssetLoad" title="播放asset音频(需自定义基座)" :clickable="true" link/>
					<uni-list-item @tap="gotoDecorView" title="操作DecorView" :clickable="true" link />
					<uni-list-item @tap="testInputDialog" title="同步获取用户输入" :clickable="true" />
					<uni-list-item @tap="testMetaRead" title="读取meta配置" :clickable="true" />
					

				</uni-list>

			</uni-collapse-item>
		</uni-collapse>


	</view>
</template>
<script>
	import {
		doTimerTask,
		doIntervalTask,
		clearIntervalTask,
		playAssetAudio,
		getUserInput,
		getMetaConfig
	} from "../../uni_modules/uts-advance";


	export default {
		data() {
			return {
				title: 'UTS进阶示例',
				taskId: 0,
			}
		},

		methods: {

			/**
			 * 测试延迟任务
			 */
			testTimer: function() {
				doTimerTask({
					start: function(response) {
						uni.showToast({
							title: response,
							icon: 'none'
						});
					},
					work: function(response) {
						uni.showToast({
							title: response,
							icon: 'none'
						});
					},
				});
			},
			/**
			 * 测试周期任务
			 */
			testInterval: function() {
				var ret = doIntervalTask({
					start: function(response) {
						uni.showToast({
							title: response,
							icon: 'none'
						});
					},
					work: function(response) {
						uni.showToast({
							title: response,
							icon: 'none'
						});
					},
				});
				this.taskId = ret.taskId;
			},
			/**
			 * 取消周期任务
			 */
			testClearInterval: function() {
				console.log(this.taskId);
				clearIntervalTask(this.taskId);
			},


			/**
			 * 跳转至资源加载演示界面
			 */
			gotoResourceDemo: function() {
				uni.navigateTo({
					url: '/pages/resource/resource'
				})
			},
			gotoDecorView: function() {
				uni.navigateTo({
					url: '/pages/advance/android/decorview'
				})
			},
			testAssetLoad() {
				// playAssetAudio();
				uni.navigateTo({
					url: '/pages/advance/android/assetaudio'
				})
			},
			testInputDialog() {
				getUserInput(function(res){
					console.log(res);
				});
			},

			testMetaRead() {
				let ret = getMetaConfig();
				uni.showToast({
					icon:"none",
					title: '读取成功,注意查看控制台输出'
				});
				console.log(ret);
			},
			testLifecyle: function() {
				uni.navigateTo({
					url: '/pages/lifecycle/lifecycle'
				})
			},
			testSyntax: function() {
				uni.navigateTo({
					url: '/pages/SyntaxCase/index'
				})
			},

		}
	}
</script>

<style>
	
</style>
