<template>
	<view>
		<page-head title="DecorView示例" accordion></page-head>
		
		<uni-list>
			<uni-list-item title="添加TextView至视图顶层" :clickable="true" @tap="testAddToDecorView"></uni-list-item> 
			<uni-list-item title="移除视图顶层的TextView" :clickable="true" @tap="testRemoveToDecorView"></uni-list-item>
		</uni-list>
			
	</view>
</template>

<script>
	import {
		addViewToDecorView,
		removeViewToDecorView
	} from "../../../uni_modules/uts-advance";
	
	export default {
		data() {
			return {
				title: 'UTS进阶示例',
			}
		},
	
		methods: {

			/**
			 * 测试添加View实例至顶层容器
			 */
			testAddToDecorView: function() {
				addViewToDecorView();
			},
			/**
			 * 测试移除顶层容器的View实例
			 */
			testRemoveToDecorView: function() {
				removeViewToDecorView();
			}
	
	
		}
	}
</script>

<style>
</style>