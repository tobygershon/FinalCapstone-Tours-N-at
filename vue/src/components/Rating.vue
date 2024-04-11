<template>
    Displays the individual rating - landmark name and thumbs up/down
    <div>
        {{ this.rating.name }}
        {{ this.rating.isGood }}
    </div>
</template>

<script>

export default {
    props: ['rating']
}

</script>