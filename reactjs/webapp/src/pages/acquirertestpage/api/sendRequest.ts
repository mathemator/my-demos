export async function sendRequest(payload: {memberId: string;
    esiaId: string;
    traceId?: string;}): Promise<void> {
    const response = await fetch("/api/your-endpoint", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
    });

    if (!response.ok) {
        const text = await response.text(); // Можно достать ошибку из тела, если есть
        throw new Error(`Ошибка при отправке запроса: ${text}`);
    }

    // ничего не возвращаем — всё прошло успешно
}