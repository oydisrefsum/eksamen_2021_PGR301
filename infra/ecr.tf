resource "aws_ecr_repository" "ecr_2018" {
  name                 = "ecr_2018"
  image_tag_mutability = "IMMUTABLE"
}