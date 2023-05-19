'use strict';

const db = uniCloud.database()

exports.main = async (event, context) => {
	let {num} = event
	return await db.collection('article').limit(num).get()
};
