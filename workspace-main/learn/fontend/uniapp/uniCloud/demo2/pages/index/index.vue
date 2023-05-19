<template>
	<view class="home">
		<uni-file-picker 
			v-model="imageValue" 
			fileMediatype="image" 
			mode="grid" 
			@select="select" 
			@progress="progress" 
			@success="success" 
			@fail="fail" 
		/>
	</view>
   
</template>

<script> 
export default {
	data() {
		return {
			imageValue: [],
			disabled: true
		};
	},
	methods: {
		// 获取上传状态
		select(e) {
			console.log('选择文件：', e);
		},
		// 获取上传进度
		progress(e) {
			console.log('上传进度：', e);
		},

		// 上传成功
		success(e) {
			console.log('上传成功');
		},

		// 上传失败
		fail(e) {
			console.log('上传失败：', e);
		}
	}
};
</script>

<style lang="scss" scoped>
	
</style>
