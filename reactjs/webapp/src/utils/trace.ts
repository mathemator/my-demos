export function generateTraceId(): string {
  return [...crypto.getRandomValues(new Uint8Array(16))]
    .map(b => b.toString(16).padStart(2, '0'))
    .join('');
}