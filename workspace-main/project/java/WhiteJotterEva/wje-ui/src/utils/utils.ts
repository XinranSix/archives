export function isEmpty(str: string): boolean {
    return null === str || '' === str
}

export function isNotEmpty(str: string): boolean {
    return !isEmpty(str)
}
