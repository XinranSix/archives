<template>
	<view class="wrap">
		<u-slider v-model="value"></u-slider>
	</view>
</template>
	
<script>
	export default {
		data() {	
			return {
				value: 30
			}
		}
	}
</script>

<style scoped lang="scss">
	.wrap {
		padding: 30rpx;
	}
</style>