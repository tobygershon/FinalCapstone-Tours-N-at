<template>
    <div>
        {{ this.rating.id }}
        <div v-if="rating.isGood">Thumbs Up</div>
        <div v-else>Thumbs Down</div>
    </div>
</template>

<script>

export default {
    props: ['rating']
}

</script>