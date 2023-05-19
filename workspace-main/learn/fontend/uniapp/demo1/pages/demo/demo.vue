<template>
	<view>
		<view>当前标题：{{ title }}</view>
		<view>{{123}}</view>
		<view>{{arr}}</view>
		<view>{{obj}}</view>
		
		<view v-if="state">uniapp 学习</view>
		<view v-else>微信小程序</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '微信小程序',
				num: 123,
				arr: ['aaa', 'bbb', 'uniapp', 1, 2, 3],
				obj: {name: '张三', age: 18},
				state: false
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
