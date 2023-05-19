export { }

console.log(1 || 2 && 3);

let obj: { name: string } & { age: number } | { name: number } & { age: string }

obj = {
    name: '1',
    age: 18
}