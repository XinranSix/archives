<template>
	<view class="add">
		<!-- {{JSON.stringify(formValue)}} -->
		<form @submit="onSubmit">
			<view class="item">
				<input v-model="formValue.title" type="text" name="title" placeholder="请输入标题">
			</view>
			<view class="item">
				<input v-model="formValue.author" type="text" name="author" placeholder="请输入作者">
			</view>
			<view class="item">
				<textarea v-model="formValue.content" name="content" placeholder="请输入内容"></textarea> 
			</view>
			<view class="item">
				<button form-type="reset">重置</button>
				<button form-type="submit" type="primary" :disabled="isDisabled()">提交</button>
			</view>
		</form>
	</view>
</template>

<script>
	export default {
		// let id;
		data() {
			return {
				formValue: {
					title: '',
					author: '',
					content: ''
				},
				detail: {}
			};
		},
		onLoad(e) {
			// console.log(e)
			
			this.getDetail(e.id)
		},
		methods: {
			getDetail(id) {
				uniCloud.callFunction({
					name: 'art_get_row',
					data: {
						id
					}
				}).then(res => {
					// console.log(res)
					this.formValue = res.result.data[0]
				})
			},
			isDisabled() {
				for (let key in this.formValue) {
					if (!this.formValue[key]) {
						return true
					}
				}
				return false
			},
			onSubmit(e) {
				// let detail = e.detail.value
				uniCloud.callFunction({
					name: 'art_update_row',
					data: {						
						detail: this.formValue
					}
				}).then((res) => {
					// console.log(res)
					uni.showToast({
						title: '修改成功'
					})
					setTimeout(() => {
						uni.navigateBack()
					}, 800)
				})
			}
		}
	}
</script>

<style lang="scss">
.add {
	padding: 30rpx;
	.item {
		padding-bottom: 20rpx;
		input, textarea {
			border: 1rpx solid #eee;
			height: 80rpx;
			padding: 0 20rpx;
		}
		textarea {
			height: 200rpx;
			width: 100%;
			box-sizing: border-box;
		}
		button {
			margin-bottom: 20rpx;
		}
	}
}
</style>
